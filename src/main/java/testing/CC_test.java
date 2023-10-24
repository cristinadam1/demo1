package testing;


import java.math.BigInteger;

import com.soap.ws.client1.CountryInfoService;
import com.soap.ws.client1.CountryInfoServiceSoapType;
import com.soap.ws.client2.NumberConversion;
import com.soap.ws.client2.NumberConversionSoapType;



public class CC_test {
    
    public static String getCountryIntPhoneCodeByISOCode(String isoCode) {
    	CountryInfoService countryInfoService = new CountryInfoService();
        CountryInfoServiceSoapType countryInfoServiceSoap = countryInfoService.getCountryInfoServiceSoap();
        return countryInfoServiceSoap.countryIntPhoneCode(isoCode);
    }
    
    public static String convert2word(String inputStr) {
  		BigInteger input_N = new BigInteger(inputStr);
  		NumberConversion NC_service = new NumberConversion(); //created service object
  		NumberConversionSoapType NC_serviceSOAP = NC_service.getNumberConversionSoap(); //create SOAP object (a port of the service)
       return NC_serviceSOAP.numberToWords(input_N);  

  	}
    public static String code2word(String isoCode) {
		String numero = getCountryIntPhoneCodeByISOCode(isoCode);
		String numero2word = convert2word(numero);
		return numero2word;
	}
    
    public static void main(String[] args) {

        System.out.println("Country Int Phone Code for ISO Code " + "US" + ": " + getCountryIntPhoneCodeByISOCode("US"));
        System.out.println("Phone code to word " + ": " + convert2word("1"));
        System.out.println("Country Int Phone Code for ISO Code " + "US" + ": " + code2word("US"));
        
    }
}

