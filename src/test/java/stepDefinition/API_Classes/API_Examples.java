package stepDefinition.API_Classes;

public class API_Examples {


//              get
//        baseURI = "https://reqres.in";
//        given().get("/api/users?page=2").then().statusCode(SC_OK)
//                .body("data.id[2]", equalTo(9), "data.first_name[2]", equalTo("Tobias")).log();


//        baseURI = "https://reqres.in";
//        given().get("/api/users?page=2").then().statusCode(SC_OK)
//                .body("data.first_name", hasItems("George", "Rachl")).log();
//

//        Post
//        baseURI = "https://reqres.in";
//        JSONObject request=new JSONObject();
//        request.put("name","sorinus");
//        request.put("job","it");
//
//        given()
//                .body(request.toJSONString())
//                .when()
//                .post("/api/users")
//                .then()
//                .statusCode(201);


    //  put
//        baseURI = "https://reqres.in";
//        JSONObject request=new JSONObject();
//        request.put("name","sorinus");
//        request.put("job","it");
//
//        given()
//                .body(request.toJSONString())
//                .when()
//                .put("/api/users/2")
//                .then()
//                .statusCode(200);


//patch
//        baseURI = "https://reqres.in";
//        JSONObject request=new JSONObject();
//        request.put("name","sorinus");
//
//
//        given()
//                .body(request.toJSONString())
//                .when()
//                .patch("/api/users/2")
//                .then()
//                .statusCode(200);

//        baseURI = "https://reqres.in";
//
//        given()
//                .when()
//                .delete("/api/users")
//                .then()
//                .statusCode(204);


//                baseURI = "http://localhost:3000";
//                JSONObject resurces=new JSONObject();
//                resurces.put("name","bibliotecara");
//                resurces.put("id",3);
//
////                .body(request.toJSONString())
////                .when()
////                .post("/api/users")
////                .then()
////                .statusCode(201);
//
//                given()
//                        .body(resurces.toJSONString())
//                        .when()
//                        .post("/subjects")
//                        .then()
//                        .statusCode(200);
////                .body("data.id[2]", equalTo(9), "data.first_name[2]", equalTo("Tobias")).log();


//        JSONObject resurces=new JSONObject();
//        resurces.put("name","ambulanta");
//        resurces.put("id","6");
////        resurces.put("id",5);
//
//        baseURI="http://localhost:3000";
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(resurces.toJSONString())
//                .when()
//                .put("/subjects/5")
//                .then()
//                .statusCode(200);

//


    // post

//        baseURI = "http://localhost:3000/";
//
//        JSONObject object = new JSONObject();
//        object.put("firstName", "mihaela");
//        object.put("lastName", "stelea");
//        object.put("id", 8);
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(object.toJSONString())
//                .when()
//                .patch("users")
//                .then()
//                .statusCode(201);

    //patch

//        baseURI = "http://localhost:3000/";

//        JSONObject object = new JSONObject();
//        object.put("firstName", "mihaela");
//        object.put("lastName", "stelea");
//        object.put("id", 7);
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(object.toJSONString())
//                .when()
//                .patch("users/7")
//                .then()
//                .statusCode(200);

    //put
//        baseURI = "http://localhost:3000/";
//
//        JSONObject object = new JSONObject();
//        object.put("firstName", "mihaela");
//        object.put("lastName", "steleA");
//        object.put("id", 7);
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(object.toJSONString())
//                .when()
//                .put("users/7")
//                .then()
//                .statusCode(200);


    //get
//        baseURI = "http://localhost:3000/";
//
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("users/7")
//                .then()
//                .statusCode(200).log().all();

    //delete

//        baseURI = "http://localhost:3000/";
//
//                when()
//                .delete("users/7")
//                .then()
//                .statusCode(200);


    //add soap
//        File file = new File("./SoapFile/fil.xml");
//        if (file.exists())
//            System.out.println("file exista");
//            FileInputStream fileInputStream = new FileInputStream(file);
//
////              toString(fileInputStream,"UTF-8");
//            baseURI = "http://www.dneonline.com";
//            given()
//                    .contentType("text/xml")
//                    .accept(ContentType.XML)
//                    //.body()
//                    .when()
//                    .post("/calculator.asmx")
//                    .then()
//                    .statusCode(200);


    //autenthification digest
//        RequestSpecification requestSpecification1=RestAssured.given();
//        requestSpecification1.baseUri("https://httpbin.org");
//        requestSpecification1.basePath("/digest-auth/undefined/sorin/sorin");
//
//        Response response=requestSpecification1.auth().digest("sorin","sorin").get();
//        System.out.println("resp "+requestSpecification1.get().statusLine());

    /// authenthification api key merge

//        String jsonData="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<Pet>\n" +
//                "\t<id>0</id>\n" +
//                "\t<Category>\n" +
//                "\t\t<id>0</id>\n" +
//                "\t\t<name>string</name>\n" +
//                "\t</Category>\n" +
//                "\t<name>ZEUS</name>\n" +
//                "\t<photoUrls>\n" +
//                "\t\t<photoUrl>string</photoUrl>\n" +
//                "\t</photoUrls>\n" +
//                "\t<tags>\n" +
//                "\t\t<Tag>\n" +
//                "\t\t\t<id>0</id>\n" +
//                "\t\t\t<name>string</name>\n" +
//                "\t\t</Tag>\n" +
//                "\t</tags>\n" +
//                "\t<status>available</status>\n" +
//                "</Pet>";
//        RequestSpecification requestSpecification1=RestAssured.given();
//        requestSpecification1.baseUri("https://petstore.swagger.io");
//        requestSpecification1.basePath("/v2/pet");
//        requestSpecification1.header("accept","application/xml");
//        requestSpecification1.header("Content-Type","application/xml");
//        requestSpecification1.body(jsonData);
//
//
//        Response response=requestSpecification1.post();
//        response.prettyPrint();
//        System.out.println(response.statusLine());
//        System.out.println(response.body());

}
