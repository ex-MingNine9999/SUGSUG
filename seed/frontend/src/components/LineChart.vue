<script>
//Importing Line class from the vue-chartjs wrapper
import {Line, mixins} from 'vue-chartjs'
//Exporting this so it can be used in other components
const { reactiveProp } = mixins

export default {
  extends: Line,
  mixins: [reactiveProp],
  props: ['chartData', 'options'],

  data () {
    return {
      datacollection: {},
        //Chart.js options that controls the appearance of the chart
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
          xAxes: [{
            gridLines: {
              display: false,
              scaleLabel: {
                display: true,
                labelString: '연도'
              }
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
  mounted() {
    //renderChart function renders the chart with the datacollection and options object.
    this.datacollection = {}
    this.datacollection = this.chartData
    this.renderChart(this.datacollection, this.options)
  },

  watch: {
    chartData: function () {
      this.datacollection = {}
      this.datacollection = this.chartData
      this.renderChart(this.datacollection, this.options)
    }
  }
}
</script>
