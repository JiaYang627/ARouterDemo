### ARouter

> 前言 此Demo为ARouter路由框架，参考一些资料，用了一天时间写出来的，时间节凑，部分地方考虑不到的后期一步步完善。

* 项目整体架构还是MVP架构，写此ARouter路由框架，旨在Module间跳转交互降低项目的耦合度。
* 基础框架为：
    * RxJava
    * Retrofit
    * OkHttp
    * RxLifecycle
    * FastJson
    * EventBus
* 其他：
    * 项目未使用Dagger2注入 。(后期会打算开一分支使用 Dagger2 注解)
    * Butter Knife注解在module间使用会报“Attribute value must be constant”错误，在今天(18-6-11)搭建的时候没有用R2的方法去解决。近期没有考虑去解决(不想用)。
    * 此Demo没有配置 支付、分享等配置，如果有其相关的第三方配置，**微信、支付宝支付、友盟微信分享、极光推送等必须写在主项目中**

* **此 Demo 大概思路：**
    * 主Module也就是App，与其他子Module之间相互建立依赖关系，再将公用的一些封装到公用的Module中，此处为 lib_common Module。子Module都与公用Module建立依赖关系。
    * 全局使用 gradle.properties 中一字段属性 isModule 对 主Module 和 子Module 进行配置，具体如下：
        * 主Module 中根据此字段进行配置 是与 子Module建立联系还是和 公用Module 建立联系。
        * 子Module 中根据此字段进行 gradle 配置：是作为library存在还是作为application存在。AndroidManifest配置：如果作为单独Module存在时是有ApplicationName，否则是没有的。
    * 主Module中不做任何Act存在(第三方配置除外：微信类)，主Module依赖的子Module中处理启动页配置。
    * 子Module间项目跳转使用的是 ARouter Path跳转，跳转路径在Demo中的 Constant类中，具体命名规范注释文档已说明。
