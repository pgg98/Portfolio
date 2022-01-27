<CsoundSynthesizer>
<CsOptions>
-W -o ej9.8.wav
</CsOptions>
<CsInstruments>

sr = 44100
nchnls = 2
0dbfs = 32768

instr sustract
  iDur   = p3
  iAmp   = ampdbfs(p4) ; amplitud de dBFS en p4 a PCM
  iFrec  = cpspch(p5)  ; de altura en p5 a frecuencia
  iVol   = 0.217       ; ganancia para controlar el volumen global

kres line 0.1, iDur, 0.40
kres2 lfo kres, 2

;DCO:

kform = 0.5*kres2

adco vco2 1, iFrec, 2, kform 
;DCF:
kfc expon 10000, iDur, 1000

kQ line 10, iDur, 1

adcf lowpass2 adco, kfc, kQ 

;EG:
kenv adsr 0.002, 0.3*iDur, 0.5, 0.3*iDur

kenv = kenv*iAmp 

;DCA:
adcf = adcf*kenv

adcf = adcf*iVol

;SALIDA:
kres3 rspline 0, 1, 1, 5

aL, aR pan2 adcf, kres3 
         outs  aL, aR
endin


</CsInstruments>
<CsScore>

t 0 128.0   ; Tempo constante desde el principio 

;    p1        p2       p3      p4      p5 
;   instr     inic.   durac.   amp.    nota 
;===========================================
i "sustract"  1.500   0.250    -3.1    8.04
i     .       1.750   0.250    -6.6    8.02
i     .       2.000   1.000    -5.0    8.04
i     .       0.000   3.501    -5.8    5.09
i     .       0.000   3.501    -5.6    6.09
i     .       3.000   2.250    -5.0    7.09
i     .       5.500   0.250    -4.2    8.05
i     .       5.750   0.250    -4.2    8.04
i     .       6.000   0.250    -5.6    8.05
i     .       6.500   0.250    -3.4    8.04
i     .       4.000   3.501    -4.0    6.05
i     .       4.000   3.501    -4.6    5.05
i     .       7.000   2.501    -3.9    8.02
i     .       9.500   0.250    -4.8    8.05
i     .       9.750   0.250    -4.4    8.04
i     .      10.000   1.000    -4.2    8.05
i     .       8.000   3.250    -5.0    6.02
i     .       8.000   3.250    -4.8    5.02
i     .      11.000   1.000    -5.4    7.09
i     .      12.000   1.501    -4.4    7.11
i     .      13.500   0.250    -4.2    8.02
i     .      13.750   0.250    -3.7    8.00
i     .      14.000   0.250    -3.7    8.02
i     .      14.500   0.250    -2.5    8.00
i     .      15.000   0.250    -3.9    7.11
i     .      12.000   3.751    -5.4    5.07
i     .      12.000   3.751    -5.0    6.07
i     .      15.500   0.250    -2.5    8.02
i     .      16.000   1.501    -2.9    8.00
i     .      16.000   1.751    -4.8    6.09
i     .      16.000   1.751    -4.7    5.09
i     .      17.500   0.250    -5.0    7.11
i     .      17.750   0.250    -4.8    8.00
i     .      18.000   1.501    -4.6    5.07
i     .      18.000   1.501    -4.4    8.02
i     .      18.000   1.501    -5.8    6.07
i     .      19.500   0.250    -4.0    8.00
i     .      19.750   0.250    -5.4    8.02
i     .      20.000   0.501    -4.4    8.04
i     .      20.500   0.500    -4.6    8.02
i     .      20.000   1.501    -3.7    7.00
i     .      20.000   1.501    -3.7    6.00
i     .      21.000   0.501    -5.8    8.00
i     .      21.500   0.250    -5.2    7.11
i     .      22.000   1.000    -4.2    7.09
i     .      22.000   1.751    -4.5    6.05
i     .      22.000   1.751    -4.7    7.05
i     .      23.000   1.000    -4.0    8.05
i     .      24.000   2.751    -6.2    8.04
i     .      24.000   3.250    -6.4    7.04
i     .      27.000   0.250    -4.7    8.04
i     .      27.250   0.251    -4.0    8.05
i     .      27.500   0.250    -4.6    8.04
i     .      27.750   0.250    -4.6    8.02
i     .      24.000   8.000    -3.4    6.04
i     .      28.000   4.000    -3.8    7.04
i     .      28.000   4.000    -3.7    8.04

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
</bsbPanel>
<bsbPresets>
</bsbPresets>
