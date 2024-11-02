import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';


export default function AppsBar() {
  return (
    <Box sx={{ flexGrow: 1 }}  style={{color:"grey"}}>
      <AppBar position="static">
        <Toolbar>
       
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            Booky
          </Typography>
         
        </Toolbar>
      </AppBar>
    </Box>
  );
}
