<template>
    <div class="wrapper ecommerce-page">
        <div class="page-header page-header-small">
            <parallax class="page-header-image" style="background-image: url('img/bg26.jpg') ;">
            </parallax>
            <div class="content-center">
                <div class="row">
                    <div class="col-md-8 ml-auto mr-auto text-center">
                        <h2 class="title">투자하려는 스타트업을 찾으세요.</h2>
                        <h4 class="description">내가 관심있는, 내가 원하는 스타트업에 투자하세요.</h4>
                    </div>
                </div>
            </div>
        </div>
        <div class="main">
            <div class="section">
                <div class="container">
                    <h2 class="section-title">기업 찾기</h2>
                    <div class="row">
                        <div class="col-md-3">
                            <div class="collapse-panel">
                                <div class="card-body">
                                    <div class="card card-refine card-plain">
                                        <h4 class="card-title">
                                            Refine
                                            <button class="btn btn-default btn-icon btn-neutral pull-right"
                                                    rel="tooltip" title="Reset Filter">
                                                <i class="arrows-1_refresh-69 now-ui-icons"></i>
                                            </button>
                                        </h4>
                                        <collapse>
                                            <collapse-item no-icon class="card-header">
                                                <h6 class="mb-0 text-primary" slot="title">
                                                    자본총계
                                                    <i class="now-ui-icons arrows-1_minimal-down"></i>
                                                </h6>
                                                <span class="price-left pull-left">{{filters.priceRange[0]}}백만원</span>
                                                <span class="price-right pull-right">{{filters.priceRange[1]}}백만원</span>
                                                <div class="clearfix"></div>
                                                <slider id="slider-refine"
                                                        class="slider-refine"
                                                        v-model="filters.priceRange"
                                                        :range="{min: 0, max: 30000}"
                                                        :connect="true">
                                                </slider>
                                            </collapse-item>
                                            <collapse-item no-icon class="card-header">
                                                <h6 class="mb-0 text-primary" slot="title">
                                                    상장여부
                                                    <i class="now-ui-icons arrows-1_minimal-down"></i>
                                                </h6>
                                                <n-checkbox v-for="corp in filters.corpTypes"
                                                            v-model="corp.value"
                                                            :key="corp.label">
                                                    {{corp.label}}
                                                </n-checkbox>
                                            </collapse-item>
                                            <collapse-item no-icon class="card-header">
                                                <h6 class="mb-0 text-primary" slot="title">
                                                    투자단계
                                                    <i class="now-ui-icons arrows-1_minimal-down"></i>
                                                </h6>
                                                <n-checkbox v-for="grade in filters.gradeTypes"
                                                            v-model="grade.value"
                                                            :key="grade.label">
                                                    {{grade.label}}
                                                </n-checkbox>
                                            </collapse-item>
                                        </collapse>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-9">
                            <div class="row">
                                <div class="col-lg-4 col-md-6"
                                     v-for="corp in corperations"
                                     :key="corp.name">
                                    <card type="product" plain>
                                        <img slot="image" :src="corp.logo" alt="">
                                        <router-link :to= "corp.link">
                                            <h4 class="card-title">{{corp.s_name}}</h4>
                                        </router-link>
                                        <p class="card-category" style="font-size:7px" align="center">
                                          {{corp.business}}
                                        </p>
                                        <p class="card-description">
                                            {{corp.birth.substr(0, 10)}}
                                        </p>
                                        <div class="card-footer">
                                            <div class="price-container">
                                                <span class="price">{{corp.price}}</span>
                                            </div>
                                            <el-tooltip effect="light" content="Remove from wishlist" placement="top">
                                                <n-button type="danger" icon round class="pull-right btn-neutral">
                                                    <i class="now-ui-icons ui-2_favourite-28"></i>
                                                </n-button>
                                            </el-tooltip>
                                        </div>
                                    </card>
                                </div>
                                <div class="col-md-3 ml-auto mr-auto">
                                    <n-button type="primary" round>Load more...</n-button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- section -->
            <div class="subscribe-line subscribe-line-image" style="background-image: url('img/bg43.jpg')">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 ml-auto mr-auto">
                            <div class="text-center">
                                <h4 class="title">Subscribe to our Newsletter</h4>
                                <p class="description">
                                    Join our newsletter and get news in your inbox every week! We hate spam too, so no
                                    worries about this.
                                </p>
                            </div>
                            <card type="raised" class="card-form-horizontal">
                                <div class="row">
                                    <div class="col-sm-8">
                                        <fg-input
                                                placeholder="Your Email..."
                                                addon-left-icon="now-ui-icons ui-1_email-85">
                                        </fg-input>
                                    </div>
                                    <div class="col-sm-4">
                                        <n-button type="primary" round block>
                                            Subscribe
                                        </n-button>
                                    </div>
                                </div>
                            </card>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
  import { Card, Button, InfoSection, FormGroupInput, Checkbox, Collapse, CollapseItem, Slider } from '@/components';
  import { axios } from 'axios';
  import { Carousel, CarouselItem, Tooltip } from 'element-ui'
  export default {
    name: 'ecommerce-page',
    bodyClass: 'ecommerce-page',
    components: {
      Card,
      InfoSection,
      Collapse,
      CollapseItem,
      Slider,
      [Button.name]: Button,
      [Checkbox.name]: Checkbox,
      [FormGroupInput.name]: FormGroupInput,
      [Carousel.name]: Carousel,
      [CarouselItem.name]: CarouselItem,
      [Tooltip.name]: Tooltip,
    },
    data() {
      return {
        post: null,
        error: null,

        filters: {
          priceRange: [0, 30000],
          corpTypeCheckAll: {
              label : 'All',
              value : true
          },
          corpTypes: [
            {
              label: '코스피 상장 기업',
              value: true
            },
            {
              label: '코스닥 상장 기업',
              value: true
            },
            {
              label: '비상장 기업',
              value: true
            },
            {
              label: '스타트업',
              value: true
            }
          ],
          gradeTypes: [
            {
              label: 'Seed',
              value: true,
            },
            {
              label: 'Series A',
              value: true,
            },
            {
              label: 'Series B',
              value: true,
            },
            {
              label: 'Series C',
              value: true,
            },
            {
              label: 'Series D',
              value: true,
            },
            {
              label: 'Series E',
              value: true,
            },
            {
              label: 'Series F',
              value: true,
            },
          ]
        },
        corperations: []
      }
    },
    created () {
        this.fetchData()
    },
    watch: {
        '$route': 'fetchData'
    },

    methods: {
      fetchData() {
        this.$http.get('api/startups').then(res => {
          for (let i in res.data) {
            this.corperations.push(res.data[i])
            this.corperations[i].link = "/corp/" + this.corperations[i].s_id
          }
        })
      }
    }
  }
</script>
<style>
</style>