HotKeySet("{NUMPAD1}", "_fun1")
HotKeySet("{NUMPAD2}", "_fun2")
HotKeySet("{F2}", "_stop")

While 1
WEnd

Func _fun1()
   Send("{CTRLDOWN}c{CTRLUP}")
   Sleep(100)
   ;$sData = _Split(ClipGet(),"--------","--------")
   $sData = StringReplace(ClipGet()," (augmented)","")
   if (StringInStr($sData,"Атак в секунду: ")>0 And StringInStr($sData,"Физический урон: ")>0) Then
	  $SA = _Split($sData,"Атак в секунду: ",@CRLF);скорость атаки
	  $minFD = _Split($sData,"Физический урон: ","-");min физический урон
	  $maxFD = _Split($sData,$minFD&"-",@CRLF);max физический урон
	  ;TrayTip("DPS", (($minFD+$maxFD)/2*$SA),0)
	  $Mpos = MouseGetPos()
	  Tooltip("DPS: "& (($minFD+$maxFD)/2*$SA),$Mpos[0],$Mpos[1])
	  Sleep(1000)
	  Tooltip("")
   EndIf
EndFunc

Func _fun2()
   Sleep(500)
   Send("{SHIFTDOWN}")
   $DPS=0
   While ($DPS<100)
	  MouseClick("LEFT")
	  Sleep(200)
	  Send("{CTRLDOWN}c{CTRLUP}")
	  $sData = _Split(ClipGet(),"--------","--------")
	  $sData = StringReplace($sData," (augmented)","")
	  if (StringInStr($sData,"Атак в секунду: ")>0 And StringInStr($sData,"Физический урон: ")>0) Then
		 $SA = _Split($sData,"Атак в секунду: ",@CRLF);скорость атаки
		 $minFD = _Split($sData,"Физический урон: ","-");min физический урон
		 $maxFD = _Split($sData,$minFD&"-",@CRLF);max физический урон
		 $DPS = ($minFD+$maxFD)/2*$SA
	  EndIf
   WEnd
   Send("{SHIFTUP}")
   TrayTip("DPS", "END",1)
EndFunc


Func _stop()
   Send("{SHIFTUP}")
   Exit
   EndFunc
Func _Split($_String, $_StrStart,$_StrEnd)
   Return StringSplit(StringSplit($_String,$_StrStart,1)[2],$_StrEnd,1)[1]
EndFunc