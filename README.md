### ARouter

> 前言 此Demo为ARouter测试Demo框架，参考一些资料，用了一天时间写出来的，部分地方考虑不到的后期一步步完善。

* 项目整体还是MVP架构，旨在Module间跳转交互降低项目的耦合度。
* 基础框架为：
    * RxJava
    * Rrtrofit
    * OkHttp
    * RxLifecycle
    * FastJson
* 其他：
    * 项目未使用Dagger2注入 。
    * Butterknife注解在module间使用会报“Attribute value must be constant”错误，在今天(18-6-11)搭建的时候没有用R2的方法去解决。
    * 此Demo没有配置 支付、分享等配置，如果有相关配置，**微信、支付宝支付、友盟微信分享、极光推送等必须写在主项目中**