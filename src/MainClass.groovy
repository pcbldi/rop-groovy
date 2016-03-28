class MainClass {
    public static void main(def args){

        def userService = new UserService()

       def response= userService.saveUser(['age':16,name:"Prakash Balodi"])
        println response
    }
}
