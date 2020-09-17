/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votacion;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Carlos
 */
@WebService(serviceName = "WSVotacion")
public class WSVotacion {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "obtenerVotacion")
    public double obtenerVotacion(@WebParam(name = "sigla") String sigla, @WebParam(name = "formato") String formato) {
        double aux=0;
        switch (formato) {
            case "votos":
                switch (sigla) {
                    case "CC":
                        aux=2162311;
                        break;
                    case "FPV":
                        aux=22671;
                        break;
                    case "MTS":
                        aux=74074;
                        break;
                    case "UCS":
                        aux=24993;
                        break;
                    case "MAS-IPSP":
                        aux=2757673;
                        break;
                    case "21F":
                        aux=247861;
                        break;
                    case "PDC":
                        aux=517368;
                        break;
                    case "MNR":
                        aux=40323;
                        break;
                    case "PAN-BOL":
                        aux=38511;
                        break;

                }
                break;
            case "porcentaje":
                switch (sigla) {
                    case "CC":
                        aux=36.74;
                        break;
                    case "FPV":
                        aux=.39;
                        break;
                    case "MTS":
                        aux=1.26;
                        break;
                    case "USC":
                        aux=0.42;
                        break;
                    case "MAS-IPSP":
                        aux=46.85;
                        break;
                    case "21F":
                        aux=4.21;
                        break;
                    case "PDC":
                        aux=8.79;
                        break;
                    case "MNR":
                        aux=0.69;
                        break;
                    case "PAN-BOL":
                        aux=0.65;
                        break;

                }
                break;
        }

        return aux;
    }
}
