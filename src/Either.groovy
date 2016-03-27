public class Either {

    final def value;

    Either(value) {
        if (value == null) {
            throw new IllegalArgumentException("Either cannot be null");
        }
        this.value = value;
    }

    Either(defaultValue,value) {
        this.value = (value == null) ? defaultValue : value;
    }

    public static Either with(value) {
        return new Either(value);
    }

    public Either or(value) {
        return new Either(this.value, value);
    }

    public def get() {
        return value;
    }

    public Either bind(Closure f) {
        Either.with(f.call(value))
    }
}