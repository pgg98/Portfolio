<CsoundSynthesizer>
<CsOptions>
-W -o ej7.5.wav
</CsOptions>
<CsInstruments>

nchnls = 1  ; sonido en mono
sr = 44100  ; frecuencia de muestreo
ksmps = 32  ; en cada ciclo de control se calculan 32 muestras

opcode fundamental, 0,fi
  fespectro, iT xin
  kfr,kamp pvspitch fespectro, 0.01
  kT timeinsts
  if kT>iT-0.1 && kT<iT+0.1 then
    printks "F0 = %d Hz\n", 1.5, kfr
  endif
endop

; PARA LA TRANSPOSICION 
instr transponer
  SFich    = p4           ; nombre del fichero del sonido
  iRTrans  = p5           ; relacion de transposicion
  iFFTSize = 1024         ; num. frecuencias calculadas
  iSolapa  = iFFTSize/4   ; solapamiento de la ventana
  iVenSize = iFFTSize     ; longitud de la ventana
  iVenTipo = 1            ; ventana tipo von Hann

  aentrada  soundin  SFich

	

  fundamental ESPECTRO_DE_SALIDA , TIEMPO_EN_SEGUNDOS
endin

</CsInstruments>
<CsScore>

t 0 60 

;      p1       p2  p3      p4        p5
;   instrum    ini dur    Fichero   R_frec 
;-----------------------------------------
i "transponer"  0  4.6 "FICHERO_WAV" [1/1]  ; sin transponer


e

</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>0</x>
 <y>0</y>
 <width>10</width>
 <height>10</height>
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
