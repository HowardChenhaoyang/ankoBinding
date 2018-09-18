package binding.anko.chy.com.library.dataBinding

import android.view.View
import binding.anko.chy.com.library.model.AnkoBindingModel
import binding.anko.chy.com.library.observable.ObservableField
import binding.anko.chy.com.library.observable.PropertyChangeListener
import binding.anko.chy.com.library.util.ListenerRegistry

abstract class AnkoDataBinding<V : View, M : AnkoBindingModel> {

    private val listenerRegistry = ListenerRegistry()
    fun bind(v: V, m: M) {
        listenerRegistry.clear()
        realBind(v, m)
        executeBindings()
    }
    fun twoWayBind(v: V, m: M) {
        listenerRegistry.clear()
        realBind(v, m)
        executeBindings()
    }
    abstract fun realBind(v: V, m: M)
    abstract fun realTwoWayBind(v: V, m: M)

    private fun executeBindings() {
        listenerRegistry.invoke()
    }

    fun <T> ObservableField<T>.propertyChange(callBack: (oldValue: T?, newValue: T?) -> Unit) {
        val propertyChange = object : PropertyChangeListener<T> {
            override fun onPropertyChanged(oldValue: T?, newValue: T?) {
                callBack.invoke(oldValue, newValue)
            }
        }
        listenerRegistry.register(this, propertyChange)
        addPropertyChangeListener(propertyChange)
    }
}