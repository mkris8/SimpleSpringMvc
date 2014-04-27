how to :
=========
1) create a new project >spring project > choose spring MVC project
2) right click on the project > run on the server > select server
3) home page comes up on the browser
4) web.xml > has the dispatcher servlet
5) web.xml > has the servlet-context.xml > helps in switching the context
6) servlet-context.xml > InternalResourceViewResolver > 
helps in > Resolves views selected for rendering by @Controllers to .jsp resources 
in the /WEB-INF/views directory
7)HomeController.java > controller . The @Controller annotation specifies that this is the controller class.
8) public methods that accepts a "Model" as input param and returns a string that represents the "view"
for eg :
@RequestMapping(value = "/pageone/pagetwo", method = 	RequestMethod.GET)
	public String pageTwo(Model model){
		return "pagetwo";
	}
	
9)@Requestmapping annotation > value for the path to be provided and the request method should also be provided.

10) return "pagetwo" > is resolved to a view in the Servlet-Context.xml file, by the view resolver.
<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />

11)It locates the views folder and looks out for the *.jsps within it.

12) how to pass params as a part of the request.

in controller, use the @RequestParam annotation
public String pageParamFromRequest(Model model, @RequestParam String userInput ){

set the param value to the model
model.addAttribute("userInputValue", userInput);
		
and, in jsp, to print the param,
User input is : ${userInputValue}

provide the input in the url from the browser like :
http://localhost:8080/simple/pageone/getparamfromrqst?userInput=100

alternatiive - RESTful way to pass in the params using @PathVariable
@RequestMapping(value = "/pageone/getparamfromrqstbypath/{userInput}"
@PathVariable String userInput
model.addAttribute("userInputValue", userInput);
in the jsp user input from path , the restful way : ${userInputValue}
http://localhost:8080/simple/pageone/getparamfromrqstbypath/100


