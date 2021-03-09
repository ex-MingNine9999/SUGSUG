<script>
//Importing Bar and mixins class from the vue-chartjs wrapper
import {Line, mixins} from 'vue-chartjs'
//Getting the reactiveProp mixin from the mixins module.
const { reactiveProp } = mixins
export default {
  extends: Line,
  mixins: [reactiveProp],
  props: ['chartData', 'options'],

  data () {
    return {
      options: {
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: false
            },
            gridLines: {
              display: true
            }
          }],
          xAxes: [ {
            gridLines: {
              display: false
            }
          }]
        },
        legend: {
          display: true
        },
        responsive: true,
        maintainAspectRatio: false
      }
    }
  },
  mounted () {
    this.renderChart(this.chartData, this.options)
  },

  watch: {
    chartData: function() {
      this.renderChart(this.chartData, this.options)
    }
  }

}
</script>
