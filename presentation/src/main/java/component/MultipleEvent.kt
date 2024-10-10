package component

internal interface MultipleEtventsCutter{
    fun processEvent(event: () -> Unit)

    companion object
}

internal fun MultipleEtventsCutter.Companion.get():MultipleEtventsCutter =MultipleEventsCutterImpI()

private class MultipleEventsCutterImpI: MultipleEtventsCutter{
    private var lastTime: Long=0
    override fun processEvent(event: () -> Unit) {
        val nowTime= System.currentTimeMillis()
        if(nowTime-lastTime>=400L){
            event.invoke()
            lastTime=nowTime
        }
    }
}