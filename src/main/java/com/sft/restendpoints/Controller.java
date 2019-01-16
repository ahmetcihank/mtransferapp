package com.sft.restendpoints;

import com.sft.Dao.AccountImpl;
import com.sft.Dao.PersonImp;
import com.sft.Helper.DBFunctions;
import com.sft.Interfaces.AccountI;
import com.sft.Interfaces.PersonI;
import com.sft.Modals.Person;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by SOFTWARE02 on 12.01.2019.
 */
@Path("/deneme")
public class Controller {
    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser( @QueryParam("senderName") String senderName,
                          @QueryParam("hello") String hello ) throws SQLException, ClassNotFoundException {
        System.out.print(senderName+ " "+ hello);
        Test d = new Test();
        d.hey ="asdas";

        return  Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(d)
                .build();
    }

    @PUT
    @Path("/updateAccount")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateAccount(@QueryParam("senderName") String senderName, @QueryParam("receiverName") String receiverName,
                                @QueryParam("moneyAmount") int moneyAmount, @QueryParam("senderAccountId") int senderAccountId,
                                @QueryParam("receiveraccountId") int receiveraccountId ) {
        try{
             AccountI accountI = new AccountImpl();
            return  Response
                    .status(200)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Headers",
                            "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Methods",
                            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .entity(accountI.updateAccount(senderName,receiverName, moneyAmount, senderAccountId,receiveraccountId))
                    .build();
        }
        catch (Exception Ex){
            return null;
        }
    }

    @GET
    @Path("/allUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(){
        try {
            PersonI personI = new PersonImp();
            return  Response
                    .status(200)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Headers",
                            "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Methods",
                            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .entity(personI.getAllPerson())
                    .build();
        }
        catch (Exception Ex){
            /* you can Uncomment and change logFile Location*/
           /* DBFunctions.WriteLog(Ex);*/
            return  null;
        }
    }

    @GET
    @Path("/allAccounts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAccounts(){
        try {
            AccountI accountI = new AccountImpl();

            return  Response
                    .status(200)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Headers",
                            "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Methods",
                            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .entity(accountI.getAllAccounts())
                    .build();
        }
        catch (Exception Ex){
           /*you can Uncomment and change logFile Location*/
           /*DBFunctions.WriteLog(Ex);*/
            return  null;
        }
    }
}

class Test
{
    public String  hey = "";
}
