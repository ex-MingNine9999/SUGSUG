const webpack = require('webpack');
const path = require('path');

module.exports = {
  outputDir: path.resolve(__dirname, "../src/main/resources/static"),

  configureWebpack: {
    // Set up all the aliases we use in our app.
    plugins: [
      new webpack.optimize.LimitChunkCountPlugin({
        maxChunks: 6
      })
    ]
  },
  pwa: {
    name: 'Now UI Kit PRO',
    themeColor: '#f96332',
    msTileColor: '#2ca8ff',
    appleMobileWebAppCapable: 'yes',
    appleMobileWebAppStatusBarStyle: '#f96332'
  },
  lintOnSave: false,
  css: {
    // Enable CSS source maps.
    sourceMap: process.env.NODE_ENV !== 'production'
  }
};
