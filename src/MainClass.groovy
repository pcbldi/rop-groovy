class MainClass {
    public static void main(def args){

        Closure divide= { mymap ->
            def d = mymap['denominator'];
            def n = mymap['numerator'];
            if (!(d))
                return new Either(right: "Cant divide By zero")
            new Either(left: (n / d))
        }
        println new Either(left: ['numerator':100, 'denominator':0]).bind(divide)
    }
}
