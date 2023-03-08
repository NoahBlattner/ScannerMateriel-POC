package com.divtec.blatnoa.scannermateriel_poc.api

class DivtecApiManager : ApiManager("https://divtec.fr/api/") {

    /**
     * Request the list of materials from the Divtec API
     * @param OnApiResponseCallback The callback to call when the request is done
     */
    public fun requestMateriels(OnApiResponseCallback: OnApiResponseCallback) {
        run("/prets/materiels", OnApiResponseCallback)
    }
}