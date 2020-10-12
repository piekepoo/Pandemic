const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    entry: "./src/index.tsx",
    devtool: "inline-source-map",
    module: {
        rules: [
            {
                test: /\.tsx?$/,
                use: "ts-loader",
                include: path.resolve(__dirname, "src"),
                exclude: /node_modules/,
            }
        ]
    },
    resolve: {
        extensions: [ ".tsx", ".ts", ".js" ]
    },
    plugins: [
        new HtmlWebpackPlugin({
            title: "P@ND3M!©",
            template: "public/index.html",
        })
    ],
    output: {
        filename: "bundle.js",
        path: path.resolve("dist"),
    },
    watch: true,
    mode: "development",
    devServer: {
        contentBase: path.join(__dirname, 'public'),
        host: '0.0.0.0',
        port: 3000,
        disableHostCheck: true,
        headers: {
          'Cache-Control': 'no-cache, no-store',
          'Expires': '-1',
        },
        proxy: {
            '/pandemic/*': 'http://localhost:8080/', // <-- change 8080 to a different port if necessary     
            }
    }
}