class UserService {


    def saveUser(Map userDetails){
        User user= new User(userDetails);
        if(!validate(user)){
            throw new Exception("Error validating user!")
            return;
        }
        if(!saveToDb(user)){
            throw new Exception("Error Inserting user in db!")
            return;
        }
        try{
            sendEmail(user)
        }
        catch (Exception e){
            println "error sending email"
            throw e;
        }
        true;
    }

    Boolean validate(User user){
        return (age > 18);
    }

    Boolean saveToDb(User user){
        println "Saving user in db!"
        return true //lol

    }

    void sendEmail(emailInfo){
        println "this method sends email."

    }

}
