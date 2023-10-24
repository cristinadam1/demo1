window.onload = customize;

function customize(){
	window.document.getElementById('div3').style.display = 'none';
}

function convertNumber()
{
    window.document.getElementById('div3').style.display = 'none';
	var q_str = 'type=number&value='+document.getElementById('t1').value; //cambiar valores
	doAjax('Country_servlet',q_str,'convertNumber_back','post',0); //cambiar nombre
}
function convertNumber_back(result) //cambiar esta funcion
{
	if (result.substring(0,5)=='error'){
	   window.document.getElementById('div3').style.display = 'block';
	   window.document.getElementById('div3').innerHTML="<p style='color:red;'><b>"+result.substring(6)+"</b></p>";
   }else{
	   window.document.getElementById('t2').value=""+result;
   }
}

function getPhoneCode()
{
    window.document.getElementById('div3').style.display = 'none';
	var q_str = 'type=price&value='+document.getElementById('t3').value; //instead of price, put phone
	doAjax('Country_servlet',q_str,'getPhoneCode_back','post',0);
}
function getPhoneCode_back(result)
{
	if (result.substring(0,5)=='error'){
	   window.document.getElementById('div3').style.display = 'block';
	   window.document.getElementById('div3').innerHTML="<p style='color:red;'><b>"+result.substring(6)+"</b></p>";
   }else{
	   window.document.getElementById('t4').value=""+result;
   }
}

function countryWord()
{
    window.document.getElementById('div3').style.display = 'none';
	var q_str = 'type=other&value='+document.getElementById('t5').value; 
	doAjax('Country_servlet',q_str,'countryWord_back','post',0);
}
function countryWord_back(result)
{
	if (result.substring(0,5)=='error'){
	   window.document.getElementById('div3').style.display = 'block';
	   window.document.getElementById('div3').innerHTML="<p style='color:red;'><b>"+result.substring(6)+"</b></p>";
   }else{
	   window.document.getElementById('t6').value=""+result;
   }
}

