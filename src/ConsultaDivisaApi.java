/*
    Author: Vladimir Mate
    Type: Record
    Description: Elemento intermediado entre las peticiones JSON de la API y la clase ConsultaDivisa
 */

public record ConsultaDivisaApi(String base_code,
                                String target_code,
                                double conversion_result) {
}