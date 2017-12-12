####
# Measure ping .. not precise but sill good representation of ping.
####
sub lag()
   var counter=0
   uo.deletejournal()
   uo.click('backpack')
   repeat
      counter=counter+1
      wait(1)

   until uo.injournal('backpack')
   uo.serverprint('Ping: '+ STR(counter) + ' ms')
end sub

####
# Keeps you hidded
####
sub hidding()
	var counter=0
	
	uo.warmode(0)
	uo.useskill("Hiding")
	
	uo.DeleteJournal() 
    repeat
		counter = counter + 1
		UO.CharPrint('self','0x002b','Hiding in ' + STR(counter))
		wait(1150) 
    until uo.InJournal('You have hidden') or uo.InJournal('You stop trying') 

   uo.useskill("Stealth")
  
   while uo.hidden()
      Wait(500)
      uo.useskill("Stealth")
   wend
end sub 

####
# Meditation
#### 
sub meditation()
   UO.CharPrint('self','0x002b','Meditando!!!')
   uo.warmode(0)
   uo.useskill("Meditation")
end sub

####
# Escape recalling and hidding with potion
#### 
sub fuga()
   uo.say(".recall 1,1")
   UO.UseType('0x0F0E','0x0001')
end sub

