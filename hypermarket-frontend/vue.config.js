const path = require('path');
const { setting } = require('./src/hypermarketConfig.js');
const devServerPort = setting.port || 8089;
const name = setting.title;

function resolve(dir) {
    return path.join(__dirname, dir);
}

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
    },
    pluginOptions: {
        "style-resources-loader": {
            preProcessor: "scss",
            patterns: [
                resolve('public/styles/_variables.scss')
            ]
        }
    }
}