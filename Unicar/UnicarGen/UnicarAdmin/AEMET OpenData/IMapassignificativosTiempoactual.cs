﻿// Code generated by Microsoft (R) AutoRest Code Generator 0.16.0.0
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

namespace UnicarAdmin
{
    using System;
    using System.Collections.Generic;
    using System.Net.Http;
    using System.Threading;
    using System.Threading.Tasks;
    using Microsoft.Rest;
    using DefaultConnection;

    /// <summary>
    /// MapassignificativosTiempoactual operations.
    /// </summary>
    public partial interface IMapassignificativosTiempoactual
    {
        /// <summary>
        /// Mapas significativos. Tiempo actual.
        /// </summary>
        /// Mapas significativos de ámbito nacional o CCAA, para el día actual
        /// (D+0),  al día siguiente (D+1) o a los dos días (D+2), en el
        /// periodo horario de (00_12) ó (12-24).
        /// <param name='ambito'>
        /// | Código | Ámbito |
        /// |----------|----------|
        /// | esp  | España|
        /// | and  | Andalucía   |
        /// | arn  | Aragón   |
        /// | ast  | Asturias  |
        /// | bal  | Ballears, Illes   |
        /// | coo  | Canarias   |
        /// | can  | Cantabria   |
        /// | cle  | Castilla y León   |
        /// | clm  | Castilla - La Mancha   |
        /// | cat  | Cataluña   |
        /// | val  | Comunitat Valenciana   |
        /// | ext  | Extremadura   |
        /// | gal  | Galicia   |
        /// | mad  | Madrid, Comunidad de    |
        /// | mur  | Murcia, Región de   |
        /// | nav  | Navarra, Comunidad Foral de   |
        /// | pva  | País Vasco |
        /// | rio  | Rioja, La
        /// </param>
        /// <param name='dia'>
        /// | Código de día | Día |
        /// |----------|----------|
        /// | a | D+0 (00-12)  |
        /// | b  | D+0 (00-12)   |
        /// |  c | D+1 (00-12)  |
        /// | d  | D+1 (12-24) |
        /// | e  | D+2 (00-12) |
        /// | f  | D+2 (12-24)
        /// </param>
        /// <param name='customHeaders'>
        /// The headers that will be added to request.
        /// </param>
        /// <param name='cancellationToken'>
        /// The cancellation token.
        /// </param>
        Task<HttpOperationResponse<object>> OneWithHttpMessagesAsync(string ambito, string dia, Dictionary<string, List<string>> customHeaders = null, CancellationToken cancellationToken = default(CancellationToken));
    }
}
