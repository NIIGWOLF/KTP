#include <Date.au3>
$Time = '0:00|1:00|2:00|3:00|4:00|5:00|6:00|7:00|8:00|9:00|10:00|11:00|12:00|13:00|14:00|15:00|16:00|17:00|18:00|19:00|20:00|21:00|22:00|23:00'
$Time2 = '0:01|1:01|2:01|3:01|4:01|5:01|6:01|7:01|8:01|9:01|10:01|11:01|12:01|13:01|14:01|15:01|16:01|17:01|18:01|19:01|20:01|21:01|22:01|23:01'
$Split = StringSplit($Time, '|')
$Split2 = StringSplit($Time2, '|')

$path = @ScriptDir & "\option.txt"
$flag=1

$file=FileReadLine($path,1)
$procces=FileReadLine($path,2)

if Not(WinGetState($procces))=True Then ShellExecute($file)

While 1
	  For $i = 1 to $Split[0]
		 If _NowTime(4) = $Split[$i] And $flag  Then
			if Not(WinGetState($procces))=True Then ShellExecute($file)
			$flag=0
		 EndIf
	  Next
   If $flag=False Then
		 For $i = 1 to $Split[0]
			If _NowTime(4) = $Split2[$i] Then $flag=1
		 Next
   EndIf
   sleep(1000)
WEnd