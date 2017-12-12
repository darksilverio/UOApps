sub wyrmleather()
   tunic()
   legs()
   sleeves()
   gloves()
   gorget()
end sub
sub tunic()
   UO.Print("Macro de Wyrm Leather para o TFGShard Iniciado")
   repeat
      UO.DeleteJournal()
      UO.WaitTargetType('0x1078','0x0902');
      UO.Usetype('0x0F9D 0x0000')
      uo.waitmenu('Leather','Monster','Wyrm','Wyrm Leather Tunic')
      while not uo.injournal('You put|falhou|cancelada')
         wait(500)
      wend
   Until UO.InJournal('You put')
end sub
sub legs()
   repeat
      UO.DeleteJournal()
      UO.WaitTargetType('0x1078','0x0902');
      UO.Usetype('0x0F9D 0x0000')
      uo.waitmenu('Leather','Monster','Wyrm','Wyrm Leather Legs')
      while not uo.injournal('You put|falhou|cancelada')
         wait(500)
      wend
   Until UO.InJournal('You put')
end sub
sub sleeves()
   repeat
      UO.DeleteJournal()
      UO.WaitTargetType('0x1078','0x0902');
      UO.Usetype('0x0F9D 0x0000')
      uo.waitmenu('Leather','Monster','Wyrm','Wyrm Leather Sleeves')
      while not uo.injournal('You put|falhou|cancelada')
         wait(500)
      wend
   Until UO.InJournal('You put')
end sub
sub gloves()
   repeat
      UO.DeleteJournal()
      UO.WaitTargetType('0x1078','0x0902');
      UO.Usetype('0x0F9D 0x0000')
      uo.waitmenu('Leather','Monster','Wyrm','Wyrm Leather Gloves')
      while not uo.injournal('You put|falhou|cancelada')
         wait(500)
      wend
   Until UO.InJournal('You put')
end sub
sub gorget()
   repeat
      UO.DeleteJournal()
      UO.WaitTargetType('0x1078','0x0902');
      UO.Usetype('0x0F9D 0x0000')
      uo.waitmenu('Leather','Monster','Wyrm','Wyrm Leather Gorget')
      while not uo.injournal('You put|falhou|cancelada')
         wait(500)
      wend
   Until UO.InJournal('You put')
end sub
sub cap()
   repeat
      UO.DeleteJournal()
      UO.WaitTargetType('0x1078','0x0902');
      UO.Usetype('0x0F9D 0x0000')
      uo.waitmenu('Leather','Monster','Wyrm','Wyrm Leather Cap')
      while not uo.injournal('You put|falhou|cancelada')
         wait(500)
      wend
   Until UO.InJournal('You put')   
end sub