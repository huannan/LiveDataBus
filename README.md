# 一个基于LiveData的事件总线框架LiveDataBus

### 基本使用

1. 发送事件

```groovy
LiveDataBus.post("event_name", 1)
```

2. 非黏性接收

```kotlin
LiveDataBus.with("event_name", Int::class.java)
        .observe(this) {
            Toast.makeText(this, "normal: $it", Toast.LENGTH_SHORT).show()
        }
```

3. 黏性接收

```kotlin
LiveDataBus.with("event_name", Int::class.java)
            .observe(this, true) {
                Toast.makeText(this, "sticky: $it", Toast.LENGTH_SHORT).show()
            }
```

### 依赖配置

1.将其添加到项目的根build.gradle中：

```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

2.添加依赖

```groovy
dependencies {
	implementation 'com.github.huannan:LiveDataBus:1.0.0'
}
```

### API详细文档

1. 通过LiveDataBus.post(String eventName, T value)发送事件；其中eventName是事件名，用于区分不同的事件；value是指具体的事件内容，支持任意类型，不限制大小。
2. 通过EventLiveData<T> with(String eventName, Class<T> type)获取通过EventLiveData，其中eventName和type必须和发送方的eventName和value的类型一一对应。
3. 拿到EventLiveData，可以通过observe或者observeForever方法来添加观察者，其中sticky参数表示是否为黏性接收
4. 备注：是否为黏性只是针对接收方而言，即是否黏性地接收，而不是事件本身是否黏性

