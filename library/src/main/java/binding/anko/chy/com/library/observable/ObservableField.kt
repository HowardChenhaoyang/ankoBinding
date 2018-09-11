package binding.anko.chy.com.library.observable

class ObservableField<T>(initValue: T? = null) : AnkoBindingObservable<T> {

    private var newValue: T? = null
    private var oldValue: T? = null

    private val propertyListeners = mutableSetOf<PropertyChangeListener<T>>()

    init {
        newValue = initValue
    }

    override fun addPropertyChangeListener(propertyChangeListener: PropertyChangeListener<T>) {
        propertyListeners.add(propertyChangeListener)
    }

    override fun removePropertyChangeListener(propertyChangeListener: PropertyChangeListener<T>) {
        propertyListeners.remove(propertyChangeListener)
    }

    fun set(t: T?) {
        if (newValue == t) {
            return
        }
        this.oldValue = newValue
        newValue = t
        notifyPropertyChange()
    }

    fun get() = newValue

    fun notifyPropertyChange() {
        for (propertyListener in propertyListeners) {
            propertyListener.onPropertyChanged(oldValue, newValue)
        }
    }
}