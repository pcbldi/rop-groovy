class MainClass {
    public static void main(def args){
        println Either.with(10).bind{ it*it}.get()
    }
}
