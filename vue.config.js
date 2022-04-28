const {
    defineConfig
} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true
})

module.exports = {
    lintOnSave: false, //关闭语法检查

    //开启代理服务器(1)
    // devServer: {
    //     proxy: 'http://localhost:5000'
    // }
    //开启代理服务器(2)
    devServer: {
        proxy: {
            //请求前缀 api 若请求前缀为/api 则走代理 否则不走代理 可以任意取名
            //在请求时不加前缀则不会走代理 会直接从public中寻找
            '/api': {
                target: 'http://localhost:5000',
                //匹配所有 /api 字符串 并将其变成 '' 空字符串
                //发送请求时则会过滤请求前缀 避免对路径造成影响
                pathRewrite: {
                    '^/api': ''
                },
                // 用于支持websocket
                // ws: true,
                // 当给服务器发请求时 若为true 则会表示当前代理服务器的端口与目标服务器的端口相同
                // 若为false 则会真实地表明自己的端口号 一般写成true 默认为true
                //用于控制请求头中的host值
                // changeOrigin: true
            },
            '/demo': {
                target: 'http://localhost:5001',
                //匹配所有 /api 字符串 并将其变成 '' 空字符串
                //发送请求时则会过滤请求前缀 避免对路径造成影响
                pathRewrite: {
                    '^/demo': ''
                },
                // 用于支持websocket
                // ws: true,
                // 当给服务器发请求时 若为true 则会表示当前代理服务器的端口与目标服务器的端口相同
                // 若为false 则会真实地表明自己的端口号 一般写成true 默认为true
                //用于控制请求头中的host值
                // changeOrigin: true
            }
        }
    }
}