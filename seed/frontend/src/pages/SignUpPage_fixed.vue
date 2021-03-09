<template>
    <div class="page-header signup-page section-image">
        <div class="page-header-image"
             style="background-image: url('img/bg18.jpg')">
        </div>
        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="card card-signup">
                            <div class="card-body">
                                <h4 class="card-title text-center">Register</h4>
                                <div class="row">
                                    <div class="col">
                                        <fg-input addon-left-icon="now-ui-icons travel_info"
                                                v-model="form.id"
                                                placeholder="ID">
                                        </fg-input>
                                        <fg-input addon-left-icon="now-ui-icons users_circle-08"
                                                v-model="form.name"
                                                placeholder="Your name...">
                                        </fg-input>
                                        <fg-input addon-left-icon="now-ui-icons ui-1_calendar-60"
                                                v-model="form.birth"
                                                placeholder="Your Birth...  ex) 95.01.01">
                                        </fg-input>
                                        <fg-input addon-left-icon="now-ui-icons ui-1_email-85"
                                                v-model="form.email"
                                                placeholder="Your Email...">
                                        </fg-input>
                                    </div>
                                    <div class="col">
                                        <fg-input addon-left-icon="now-ui-icons ui-1_lock-circle-open"
                                                v-model="form.password"
                                                placeholder="Password">
                                        </fg-input>
                                        <fg-input addon-left-icon="now-ui-icons ui-1_lock-circle-open"
                                                v-model="form.passConfirm"
                                                placeholder="Password Confirm">
                                        </fg-input>
                                        <fg-input addon-left-icon="now-ui-icons tech_mobile"
                                                v-model="form.phone"
                                                placeholder="Your Phone Number...">
                                        </fg-input>
                                        <fg-input addon-left-icon="now-ui-icons business_globe"
                                                v-model="form.address"
                                                placeholder="Your Address..">
                                        </fg-input>
                                    </div>
                                </div>
                                <n-checkbox v-model="form.agree">
                                    If you are startup owner, Check please.
                                <a href="#something">conditions</a>.
                                </n-checkbox>
                                <div class="card-footer text-center" @click="startBtn">
                                    <n-button type="primary" round size="lg">Get Started</n-button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <main-footer></main-footer>
    </div>
</template>
<script>
  import { Card, Button, FormGroupInput, Checkbox } from '@/components';
  import MainFooter from '@/layout/MainFooter';

  export default {
    name: 'signup-page',
    bodyClass: 'signup-page',
    components: {
      Card,
      MainFooter,
      [Button.name]: Button,
      [Checkbox.name]: Checkbox,
      [FormGroupInput.name]: FormGroupInput
    },
    data() {
      return {
        form: {
          id: '',
          password: '',
          passConfirm: '',
          address: '',
          email: '',
          name: '',
          phone: '',
          birth: '',

          agree: false
        }
      }
    },

    methods: {
        startBtn: function() {
            
        }
    }
  }
</script>
<style>
</style>
