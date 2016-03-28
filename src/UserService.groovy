class UserService {


    def saveUser(Map userDetails){
        User user= new User(userDetails);
       Either result= new Either(left: user)
                .bind(validate)
                .bind(saveToDb)
                .bind(sendEmail)
        return result.value()
    }

    Closure validate={ User user->
        if(user.age<18){
            return new Either(right: "User age is less than 18")
        }
        return new Either(left: user)
    }

    Closure saveToDb={ User user->
        try {
            if(getRandomBoolean()){
                return( new Either(left: user))
            }
            else{
                throw new Exception("DB is not working");
            }

        }
        catch (Exception e){
            return (new Either(right:"Error saving in db, ${e.message}"))
        }

    }

    Closure sendEmail={ emailInfo->
        try {
            if(getRandomBoolean()){
                return( new Either(left: emailInfo))
            }
            else{
                throw new Exception("Mail server not working");
            }

        }
        catch (Exception e){
            return (new Either(right:"Error sending email, ${e.message}"))
        }

    }

    Boolean getRandomBoolean(){
        new Random().nextLong()%2 as Boolean
    }

}
