package com.kim.presentation.component.modifier

internal interface MultipleEventsCutter{
    fun processEvent(event: () -> Unit)

    companion object
}

internal fun MultipleEventsCutter.Companion.get():MultipleEventsCutter =MultipleEventsCutterImpI()

private class MultipleEventsCutterImpI(): MultipleEventsCutter{
    private var lastTime: Long=0
    override fun processEvent(event: () -> Unit) {
        val nowTime= System.currentTimeMillis()
        if(nowTime-lastTime>=400L){
            event.invoke()
            lastTime=nowTime
        }
    }
}