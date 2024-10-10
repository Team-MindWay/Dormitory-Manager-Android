package com.kim.presentation.component.modifier

internal interface MultipleEventsCutter{
    fun processEvent(event: () -> Unit)

    companion object
}

internal fun MultipleEventsCutter.Companion.get():MultipleEventsCutter =MultipleEventsCutterImpI()

private class MultipleEventsCutterImpI(private val delay: Long=400L): MultipleEventsCutter{
    private var lastTime: Long=0
    override fun processEvent(event: () -> Unit) {
        val nowTime= System.currentTimeMillis()
        if(nowTime-lastTime>=delay){
            event.invoke()
            lastTime=nowTime
        }
    }
}