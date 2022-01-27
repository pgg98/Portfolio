﻿// Code generated by Microsoft (R) AutoRest Code Generator 0.16.0.0
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

namespace UnicarAdmin
{
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.Threading;
    using System.Threading.Tasks;
    using Microsoft.Rest;
    using DefaultConnection;

    /// <summary>
    /// Extension methods for MapassignificativosTiempoactual.
    /// </summary>
    public static partial class MapassignificativosTiempoactualExtensions
    {
            /// <summary>
            /// Mapas significativos. Tiempo actual.
            /// </summary>
            /// Mapas significativos de ámbito nacional o CCAA, para el día actual (D+0),
            /// al día siguiente (D+1) o a los dos días (D+2), en el periodo horario de
            /// (00_12) ó (12-24).
            /// <param name='operations'>
            /// The operations group for this extension method.
            /// </param>
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
            public static object One(this IMapassignificativosTiempoactual operations, string ambito, string dia)
            {
                return Task.Factory.StartNew(s => ((IMapassignificativosTiempoactual)s).OneAsync(ambito, dia), operations, CancellationToken.None, TaskCreationOptions.None, TaskScheduler.Default).Unwrap().GetAwaiter().GetResult();
            }

            /// <summary>
            /// Mapas significativos. Tiempo actual.
            /// </summary>
            /// Mapas significativos de ámbito nacional o CCAA, para el día actual (D+0),
            /// al día siguiente (D+1) o a los dos días (D+2), en el periodo horario de
            /// (00_12) ó (12-24).
            /// <param name='operations'>
            /// The operations group for this extension method.
            /// </param>
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
            /// <param name='cancellationToken'>
            /// The cancellation token.
            /// </param>
            public static async Task<object> OneAsync(this IMapassignificativosTiempoactual operations, string ambito, string dia, CancellationToken cancellationToken = default(CancellationToken))
            {
                using (var _result = await operations.OneWithHttpMessagesAsync(ambito, dia, null, cancellationToken).ConfigureAwait(false))
                {
                    return _result.Body;
                }
            }

    }
}