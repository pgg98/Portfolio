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
    /// Extension methods for DatosdeobservaciónTiempoactual.
    /// </summary>
    public static partial class DatosdeobservaciónTiempoactualExtensions
    {
            /// <summary>
            /// Datos de observación. Tiempo actual.
            /// </summary>
            /// Datos de observación horarios de las últimas 24 horas de la estación
            /// meterológica que se pasa como parámetro (idema). Frecuencia de
            /// actualización: continuamente.
            /// <param name='operations'>
            /// The operations group for this extension method.
            /// </param>
            /// <param name='idema'>
            /// Índicativo climatológico de la EMA
            /// </param>
            public static object One(this IDatosdeobservaciónTiempoactual operations, string idema)
            {
                return Task.Factory.StartNew(s => ((IDatosdeobservaciónTiempoactual)s).OneAsync(idema), operations, CancellationToken.None, TaskCreationOptions.None, TaskScheduler.Default).Unwrap().GetAwaiter().GetResult();
            }

            /// <summary>
            /// Datos de observación. Tiempo actual.
            /// </summary>
            /// Datos de observación horarios de las últimas 24 horas de la estación
            /// meterológica que se pasa como parámetro (idema). Frecuencia de
            /// actualización: continuamente.
            /// <param name='operations'>
            /// The operations group for this extension method.
            /// </param>
            /// <param name='idema'>
            /// Índicativo climatológico de la EMA
            /// </param>
            /// <param name='cancellationToken'>
            /// The cancellation token.
            /// </param>
            public static async Task<object> OneAsync(this IDatosdeobservaciónTiempoactual operations, string idema, CancellationToken cancellationToken = default(CancellationToken))
            {
                using (var _result = await operations.OneWithHttpMessagesAsync(idema, null, cancellationToken).ConfigureAwait(false))
                {
                    return _result.Body;
                }
            }

    }
}
