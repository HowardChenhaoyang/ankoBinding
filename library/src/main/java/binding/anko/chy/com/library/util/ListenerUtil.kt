package binding.anko.chy.com.library.util

import binding.anko.chy.com.library.observable.ObservableField
import binding.anko.chy.com.library.observable.PropertyChangeListener
import java.lang.ref.WeakReference

class ListenerRegistry {

    private val listeners = mutableListOf<ListenerBean<*>>()

    fun <T> register(observable: ObservableField<T>, propertyChangeListener: PropertyChangeListener<T>) {
        listeners.add(ListenerBean<T>().apply {
            this.observable = WeakReference(observable)
            this.propertyChangeListener = propertyChangeListener
        })
    }

    fun invoke() {
        for (listener in listeners) {
            listener.observable.get()?.notifyPropertyChange()
        }
    }

    fun clear() {
        for (listener in listeners) {
            listener.remove()
        }
    }
}

private class ListenerBean<T> {

    lateinit var observable: WeakReference<ObservableField<T>>
    lateinit var propertyChangeListener: PropertyChangeListener<T>

    fun remove() {
        observable.get()?.removePropertyChangeListener(propertyChangeListener)
    }
}