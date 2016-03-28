public class Either {

    def left;
    def right;

    public def isLeft(){
        left as boolean
    }

    public def isRight(){
        right as boolean
    }

    public def value(){
        isLeft()?left:right
    }

    public Either bind(Closure f) {
        if(isLeft()){
         return f(this.left)
        }
        this
    }
}