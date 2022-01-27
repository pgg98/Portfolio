<CsoundSynthesizer>
<CsOptions>
-W -o ej6.6.wav ; fichero de salida si Render
</CsOptions>
<CsInstruments>

; Parametros de cabecera:
sr = 44100 ; frecuencia de muestreo
ksmps =  1 ; muestras por ciclo - debe ser 1 por la realimentacion
0dbfs =  1 ; maxima amplitud del rango

seed 1     ; semilla para generador de numeros aleatorios

; operador definido aqui que mide Apico 4 veces/segundo
opcode ganancia, 0,a
  as xin
  kApico init     0
  kTrig  metro    4, 0.25
  kApico max_k    as, kTrig, 1
         printks "%5.2f dBFS\n",0.25,dbfsamp(kApico)
endop

; Instrumento FPB IIR de orden 1 con fc variable

instr fpbIIR
  prints "Ganancia en dB:\n"
  aout  init  0  ; crea e inicializa aout
  aini  init  0
  
  iai = p4
  iaf = p5
  it  = p3
  
  aini rand 0dbfs
  
  kres line iai, it, iaf
  
  aout=(1-kres)*aini+kres*aout
  
  out aout
	
        ganancia aout
endin

</CsInstruments>
<CsScore>

t 0 60   ; tempo 60 BPM (1 tiempo = 1 segundo)

;   p1     p2  p3   p4    p5
; instrum ini dur  aini  afin
;------------------------------"
i "fpbIIR" 0 4 0.2 0.99
e

</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>0</x>
 <y>0</y>
 <width>0</width>
 <height>0</height>
 <visible>true</visible>
 <uuid>{a34025d3c6cfbfc143e7f4cc6c24f135}</uuid>
 <bgcolor mode="nobackground">
  <r>255</r>
  <g>255</g>
  <b>255</b>
 </bgcolor>
 <bsbObject type="BSBGraph" version="2">
  <objectName>outFT</objectName>
  <x>3</x>
  <y>7</y>
  <width>505</width>
  <height>189</height>
  <uuid>{c4fea1c8-ec71-4294-aa36-650cc5d248d3}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <value>0</value>
  <objectName2>tab_outFT</objectName2>
  <zoomx>2.00000000</zoomx>
  <zoomy>1.00000000</zoomy>
  <dispx>1.00000000</dispx>
  <dispy>1.00000000</dispy>
  <modex>lin</modex>
  <modey>lin</modey>
  <showSelector>true</showSelector>
  <showGrid>true</showGrid>
  <showTableInfo>true</showTableInfo>
  <showScrollbars>true</showScrollbars>
  <enableTables>true</enableTables>
  <enableDisplays>true</enableDisplays>
  <all>true</all>
 </bsbObject>
</bsbPanel>
<bsbPresets>
</bsbPresets>
