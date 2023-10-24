package clientWS_C;

import java.math.BigInteger;

import com.soap.ws.client2.NumberConversion;
import com.soap.ws.client2.NumberConversionSoapType;
import com.soap.ws.client1.CountryInfoService;
import com.soap.ws.client1.CountryInfoServiceSoapType;

public class CountryConvertor {
	public CountryConvertor() {}
    
	/**
	 * Retrieves the phone code of a country based on its ISO code using a SOAP web service.
	 *
	 * @param isoCode The ISO code of the country for which the phone code is requested.
	 * @return The phone code of the specified country as a String.
	 */
    public String getCountryPhoneCodeByISOCode(String isoCode) {
    	CountryInfoService countryInfoService = new CountryInfoService();
        CountryInfoServiceSoapType countryInfoServiceSoap = countryInfoService.getCountryInfoServiceSoap();
        return countryInfoServiceSoap.countryIntPhoneCode(isoCode);
    }
    
    /**
     * Converts a numeric input to its word representation using a SOAP web service.
     *
     * @param inputStr The numeric input as a String to be converted to words.
     * @return The word representation of the input number as a String.
     */
    public String convert2word(String inputStr) {
		BigInteger input_N = new BigInteger(inputStr);
		NumberConversion NC_service = new NumberConversion(); 
		NumberConversionSoapType NC_serviceSOAP = NC_service.getNumberConversionSoap(); 
        String result = NC_serviceSOAP.numberToWords(input_N);  
        return result;
	}
    
    public String code2word(String isoCode) {
		String numero = getCountryPhoneCodeByISOCode(isoCode);
		String numero2word = convert2word(numero);
		return numero2word;
	}
     
}

