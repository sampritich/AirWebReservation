function onCheck()
{
	var passenger = document.getElementById("passenger").value;
	var status=false;
	
	for(var i=0;i<passenger;i++)
	{
		var salutation = document.getElementById("salutation"+(i+1)).value;
		var firstname = document.getElementById("firstname"+(i+1)).value;
		var lastname = document.getElementById("lastname"+(i+1)).value;
		
		if(salutation.length == 0)
		{
			status=false;
			alert(" Salutation cannot be Empty");
		}
		else
		{
			status=true;
		}
		if(firstname.length == 0)
		{
			
			document.getElementById("firstname"+(i+1)).innerText = "*This Field is Mandatory*";
			alert("Firstname of Passenger "+(i+1)+ " cannot be Empty");
			
			status=false;
		}
		else
		{
			status=true;
		}
		
		if(lastname.length == 0)
		{
			status=false;
			document.getElementById("lastname"+(i+1)).innerText = "*This Field is Mandatory*";
			alert("Lastname of Passenger "+(i+1)+ " cannot be Empty");
		}
		else
		{
			status=true;
		}
		
	}
	return status;
}