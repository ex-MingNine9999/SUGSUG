<template>
    <div class="wrapper blog-post">
        <div class="page-header page-header-small">
            <parallax class="page-header-image" style="background-image: url('img/bg32.jpg')"></parallax>
            <div class="content-center">
                <div class="row">
                    <div class="col-md-8 ml-auto mr-auto text-center">
                        <h2 class="title">투자하고 싶은 기업은 어떤 기업인가요?</h2>
                        <h4>SUGSUG이 쑥쑥 클 수 있도록 도와드리겠습니다.</h4>
                    </div>
                </div>
            </div>
        </div>
        <div class="section">
            <div class="container">
                <div class="row">
                  <div class="col-md-12">
                     <div class="button-container">
                       <a href="#pablo" class="btn btn-primary btn-round btn-lg">
                         <i class="now-ui-icons text_align-left"></i> 프리미엄 서비스 바로가기
                       </a>
                     </div>
                  </div>
                </div>
            </div>
            <div class="section">
                <div class="container">
                    <div class="row">
                      <div style="float: left; width: 9%;"></div>
                      <div style="float: left; width: 25%; padding:9px;">
                        <img slot="image" :src="corpBaseData.logo">
                      </div>
                      <div style="float: left; width: 50%; padding:10px;">
                        <h2 class="title" >{{ corpBaseData.s_name }}</h2>
                        <p>
                          CEO : {{ corpDetailData.ceo }}<br/>
                          HomePage : {{ corpDetailData.homepage }}<br/>
                          Phone : {{ corpBaseData.phone }}<br/>
                          Address : {{ corpDetailData.address }}<br/>
                        </p>
                      </div>
                      <div class="section section-blog col-md-10 ml-auto mr-auto">
                        <h3 align="center">대표 서비스</h3>
                        <div class="container">
                          <div class="section-story-overview">
                            <div class="row">
                              <div class="col-md-1"></div>
                              <div class="col-md-5">
                                <!-- First image on the right side, above the article -->
                                <h3>{{ corpDetailData.product }}</h3>
                                <p>
                                  분야 : {{ corpDetailData.technology }}
                                </p>
                                <p>
                                  서비스 : {{ corpDetailData.service }}
                                </p>
                                <p>

                                </p>
                              </div>
                              <div class="col-md-1"></div>
                              <div class="col-md-4">
                                <div class="image-container"
                                     v-bind:style="{ 'background-image':'url('+corpDetailData.icon+')' }">
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="col-md-10 ml-auto mr-auto">
                        <p class="blockquote blockquote-primary" v-html="corpDetailData.introduction"></p>
                      </div>
                    </div>
                </div>
            </div>
            <div class="section">
              <div class="container">
                <div class="row">
                  <div class="col-md-5 ml-auto mr-auto">
                    <LineChart v-if="loaded" :chartData="sales"></LineChart>
                    <h5 align="center" v-if="(corpYearData.sales[corpLength - 1] / 10000) > 1">{{ corpYearData.year[corpLength - 1]}}년 기준 {{ Math.floor(corpYearData.sales[corpLength - 1] / 10000)}}억 {{ corpYearData.sales[corpLength - 1] % 10000 }}만원</h5>
                    <h5 align="center" v-else>{{ corpYearData.year[corpLength - 1]}}년 기준 &nbsp;&nbsp;&nbsp;{{ corpYearData.sales[corpLength - 1] }}만원</h5>
                 </div>
                  <div class="col-md-5 ml-auto mr-auto">
                    <LineChart v-if="loaded" :chartData="investment"></LineChart>
                    <h5 align="center" v-if="(corpYearData.investment[corpLength - 1] / 10000) > 1">{{ corpYearData.year[corpLength - 1]}}년 기준 {{ Math.floor(corpYearData.investment[corpLength - 1] / 10000)}}억 {{ corpYearData.investment[corpLength - 1] % 10000 }}만원</h5>
                    <h5 align="center" v-else>{{ corpYearData.year[corpLength - 1]}}년 기준 &nbsp;&nbsp;&nbsp;{{ corpYearData.investment[corpLength - 1] }}만원</h5>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-5 ml-auto mr-auto">
                    <LineChart v-if="loaded" :chart-data="total"></LineChart>
                    <h5 align="center" v-if="(corpYearData.total[corpLength - 1] / 10000) > 1">{{ corpYearData.year[corpLength - 1]}}년 기준 {{ Math.floor(corpYearData.total[corpLength - 1] / 10000)}}억 {{ corpYearData.total[corpLength - 1] % 10000 }}만원</h5>
                    <h5 align="center" v-else>{{ corpYearData.year[corpLength - 1]}}년 기준 &nbsp;&nbsp;&nbsp;{{ corpYearData.total[corpLength - 1] }}만원</h5>
                  </div>
                  <div class="col-md-5 ml-auto mr-auto">
                    <LineChart v-if="loaded" :chart-data="profit"></LineChart>
                    <h5 align="center" v-if="(corpYearData.profit[corpLength - 1] / 10000) > 1">{{ corpYearData.year[corpLength - 1]}}년 기준 {{ Math.floor(corpYearData.profit[corpLength - 1] / 10000)}}억 {{ corpYearData.profit[corpLength - 1] % 10000 }}만원</h5>
                    <h5 align="center" v-else>{{ corpYearData.year[corpLength - 1]}}년 기준 &nbsp;&nbsp;&nbsp;{{ corpYearData.profit[corpLength - 1] }}만원</h5>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-5 ml-auto mr-auto">
                    <LineChart v-if="loaded" :chart-data="capital"></LineChart>
                    <h5 align="center" v-if="(corpYearData.capital[corpLength - 1] / 10000) >1">{{ corpYearData.year[corpLength - 1]}}년 기준 {{ Math.floor(corpYearData.capital[corpLength - 1] / 10000)}}억 {{ corpYearData.capital[corpLength - 1] % 10000 }}만원</h5>
                    <h5 align="center" v-else>{{ corpYearData.year[corpLength - 1]}}년 기준 &nbsp;&nbsp;&nbsp;{{ corpYearData.capital[corpLength - 1] }}만원</h5>
                  </div>
                  <div class="col-md-5 ml-auto mr-auto">
                    <LineChart v-if="loaded" :chart-data="paidCapital"></LineChart>
                    <h5 align="center" v-if="(corpYearData.paidCapital[corpLength - 1] / 10000) > 1">{{ corpYearData.year[corpLength - 1]}}년 기준 {{ Math.floor(corpYearData.paidCapital[corpLength - 1] / 10000)}}억 {{ corpYearData.paidCapital[corpLength - 1] % 10000 }}만원</h5>
                    <h5 align="center" v-else>{{ corpYearData.year[corpLength - 1]}}년 기준 &nbsp;&nbsp;&nbsp;{{ corpYearData.paidCapital[corpLength - 1] }}만원</h5>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-5 ml-auto mr-auto">
                    <LineChart v-if="loaded" :chart-data="curIncome"></LineChart>
                    <h5 align="center" v-if="(corpYearData.curIncome[corpLength - 1] / 10000) > 1">{{ corpYearData.year[corpLength - 1]}}년 기준 {{ Math.floor(corpYearData.curIncome[corpLength - 1] / 10000)}}억 {{ corpYearData.curIncome[corpLength - 1] % 10000 }}만원</h5>
                    <h5 align="center" v-else>{{ corpYearData.year[corpLength - 1]}}년 기준 &nbsp;&nbsp;&nbsp;{{ corpYearData.curIncome[corpLength - 1] }}만원</h5>
                  </div>
                  <div class="col-md-5 ml-auto mr-auto">
                    <LineChart v-if="loaded" :chart-data="people"></LineChart>
                    <h5 align="center" >{{ corpYearData.year[corpLength - 1]}}년 기준 &nbsp;&nbsp;&nbsp;{{ corpYearData.people[corpLength - 1] }}명</h5>
                  </div>
                </div>
              </div>
            </div>
            <div class="section section-comments">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 ml-auto mr-auto">
                            <div class="media-area">
                                <h3 class="title text-center">Comments</h3>
                                <comment v-for="comment in comments"
                                         :avatar="comment.avatar"
                                         :author="comment.author"
                                         :date="comment.date"
                                         :comment="comment.comment"
                                         :replies="comment.replies"
                                         :key="comment.id">
                                </comment>
                            </div>
                            <h3 class="title text-center">Post your comment</h3>
                            <div class="media media-post">
                                <a class="pull-left author" href="#pablo">
                                    <div class="avatar">
                                        <img class="media-object img-raised" alt="64x64" src="img/olivia.jpg">
                                    </div>
                                </a>
                                <div class="media-body">
                                    <textarea class="form-control" v-model="form.comment"
                                              placeholder="Write a nice reply or go home..." rows="4"></textarea>
                                    <div class="media-footer">
                                        <a href="#pablo" class="btn btn-primary pull-right">
                                            <i class="now-ui-icons ui-1_send"></i> Reply
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <!-- end media-post -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
  import { Card, Button, Comment, Badge, InfoSection, Checkbox } from '@/components';
  import LineChart from "@/components/LineChart";
  import {Line, mixins} from 'vue-chartjs'
  import Reactive from "@/components/Reactive";

  const { reactiveProp } = mixins

  export default {
    name: 'corperation',
    bodyClass: 'corperation',
    components: {
      Reactive,
      LineChart,
      Card,
      InfoSection,
      Badge,
      Comment,
      [Button.name]: Button,
      [Checkbox.name]: Checkbox
    },
    data() {
      return {
        form: {
          comment: ''
        },
        loaded: false,
        corpBaseData: {},
        corpDetailData: {},
        corpYearData: {
          year: [],
          total: [],
          paidCapital: [],
          capital: [],
          profit: [],
          sales: [],
          curIncome: [],
          investment: [],
          people: []
        },
        corpLength: 0,

        year: null,
        total: null,
        paidCapital: null,
        capital: null,
        profit: null,
        sales: null,
        curIncome: null,
        investment: null,
        people: null
      }
    },

    async created() {
      await this.fetchData()
    },

    watch: {
      '$route': 'fetchData'
    },

    async mounted() {
      this.loaded = false
      await this.fillData()
      this.loaded = true

      console.log(this.loaded)
    },

    beforeUpdate() {

    },

    updated() {

    },

    methods: {
      fetchData() {
        let corpId = this.$route.params.corpId;

        this.$http.get('api/startup?corpId=' + corpId).then(res => {
          this.corpBaseData = res.data;
        })
        this.$http.get('api/startup-detail?corpId=' + corpId).then(res => {
          this.corpDetailData = res.data;
        })
        this.$http.get('api/startup-year?corpId=' + corpId).then(res => {
          for (let i in res.data) {
            this.corpYearData.year.push(res.data[i].s_year);
            this.corpYearData.total.push(res.data[i].total);
            this.corpYearData.paidCapital.push(res.data[i].paid_capital);
            this.corpYearData.capital.push(res.data[i].capital);
            this.corpYearData.profit.push(res.data[i].profit);
            this.corpYearData.sales.push(res.data[i].sales);
            this.corpYearData.curIncome.push(res.data[i].cur_income);
            this.corpYearData.investment.push(res.data[i].investment);
            this.corpYearData.people.push(res.data[i].people);
            this.corpLength++
          }
        })

      },

      fillData() {
        this.sales = {
          labels: this.corpYearData.year,
          datasets: [{
            label: '매출액(만원)',
            backgroundColor: '#7979F8',
            borderColor: '#7979F8',
            data: this.corpYearData.sales,
            fill: false
          }]
        }

        this.investment = {
          labels: this.corpYearData.year,
          datasets: [{
            label: '투자금(만원)',
            backgroundColor: '#79F879',
            borderColor: '#79F879',
            data: this.corpYearData.investment,
            fill: false
          }]
        }

        this.total = {
          labels: this.corpYearData.year,
          datasets: [{
            label: '총 자산(만원)',
            backgroundColor: '#F87979',
            borderColor: '#F87979',
            data: this.corpYearData.total,
            fill: false
          }]
        }

        this.profit = {
          labels: this.corpYearData.year,
          datasets: [{
            label: '영업 이익(만원)',
            backgroundColor: '#79F8F8',
            borderColor: '#79F8F8',
            data: this.corpYearData.profit,
            fill: false
          }]
        }

        this.capital = {
          labels: this.corpYearData.year,
          datasets: [{
            label: '자본 총계(만원)',
            backgroundColor: '#7979F8',
            borderColor: '#7979F8',
            data: this.corpYearData.capital,
            fill: false
          }]
        }

        this.paidCapital = {
          labels: this.corpYearData.year,
          datasets: [{
            label: '납입 자본금(만원)',
            backgroundColor: '#79F879',
            borderColor: '#79F879',
            data: this.corpYearData.paidCapital,
            fill: false
          }]
        }

        this.curIncome = {
          labels: this.corpYearData.year,
          datasets: [{
            label: '당기 순이익(만원)',
            backgroundColor: '#f87979',
            borderColor: '#f87979',
            data: this.corpYearData.curIncome,
            fill: false
          }]
        }

        this.people = {
          labels: this.corpYearData.year,
          datasets: [{
            label: '직원 수(명)',
            backgroundColor: '#79F8F8',
            borderColor: '#79F8F8',
            data: this.corpYearData.people,
            fill: false
          }]
        }
      }
    },

    computed: {

    }
  }


</script>
<style>
</style>
