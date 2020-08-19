var util ={
    regExpyear : "/^([0-9]{0,4})/",
    regExpday : "^/([0-9],{0,2})/",
    vaildation: function(year,day,password, checking){
        if(!this.regExpyear.test(year)){
            alert("Year");
            return;
        }
        if(!this.regExpday.test(day)){
            alert("day");
            return;
        }
        if(!password != checking){
            alert("plz check password")
            return;
        }
        $('#form').submit();
    }

}




