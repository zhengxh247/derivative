const path = require('path');
const { setting } = require('./src/hypermarketConfig.js');
const devServerPort = setting.port || 8089;
const name = setting.title;

module.exports = {
    devServer: {
        port: devServerPort,
        open: true,
        overlay: {
            warnings: false,
            errors: true
        }
        // proxy: {}
    },
    chainWebpack(config) {
        config.set('name', name)
    }
}