; PARA LA LECTURA DE LOS VALORES DE LOS PARAMETROS DE FORMATO
<CsoundSynthesizer>
<CsOptions>
-n   ; este programa no genera audio
</CsOptions>
<CsInstruments>

instr format
  SFich = p4  ; parametro recibido desde la partitura con el nombre del fichero

  ifs    filesr     SFich  ; devuelve la frecuencia de muestreo del fichero
  iNChan filenchnls SFich  ; devuelve el numero de canales del fichero
  iNBit  filebit    SFich  ; devuelve al resolucion en bits del fichero
  iDura  filelen    SFich  ; devuelve la duracion en segundos del fichero

         print      ifs, iNChan, iNBit, iDura ; se escriben los que se leen directamente

  iBytes = 2                ; calcula los bytes por muestra
  iFlujo = 44100                ; calcula el flujo
  iMuest = 44100                ; calcula el num. muestras en la sennal

         print    iBytes, iFlujo, iMuest         ; y aqui se escriben los calculados, separados por comas
         prints     "\n"   ; salto de linea para separar
endin

</CsInstruments>
<CsScore>

; Activa el instrumento format enviando el nombre del fichero a analizar.
; La duracion de la activacion es irrelevante

;   inst  inic  dur    fichero
;    p1    p2    p3      p4
;--------------------------------------
i "format"  0   0.1  "5.1.62.wav" 

e

</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>100</x>
 <y>100</y>
 <width>320</width>
 <height>240</height>
 <visible>true</visible>
 <uuid>{a34025d3c6cfbfc143e7f4cc6c24f135}</uuid>
 <bgcolor mode="nobackground">
  <r>255</r>
  <g>255</g>
  <b>255</b>
 </bgcolor>
</bsbPanel>
<bsbPresets>
</bsbPresets>
