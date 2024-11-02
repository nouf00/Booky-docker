import React, { useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import { Container, Paper } from '@mui/material';
import Typography from '@mui/material/Typography';
import AddIcon from '@mui/icons-material/Add';
import ListIcon from '@mui/icons-material/List';
import VisibilityIcon from '@mui/icons-material/Visibility';
import { useNavigate } from "react-router-dom";
import Link from '@mui/material/Link';


export default function AddBook() {
    const navigate = useNavigate();

  const [isbn, setIsbn] = useState('');

  const handleAddBook = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/newbook/addbook?isbn='+isbn, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',

          },
        });

      if (response.ok) {
        alert('Book added successfully');
        console.log(response);
      } else {
        alert('Failed to add the book');
        console.log(response);
      }
    } catch (error) {
      console.error('Error adding book:', error);
      alert('Error adding book');
    }
  };




  const handleAddToReadingList = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/readinglist/add-to-list?isbn='+isbn, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',

        },
      });

      if (response.ok) {
        alert('Book added to list successfully');
        console.log(response);
      } else {
        alert('Failed to add the book to list, because it not exit in main book list'  );
        console.log(response);
      }
    } catch (error) {
      console.error('Error adding book to list:', error);
      alert('Error adding book to list');
    }
  };

  return (
    <Box mt={10} p={5}>
      <Container maxWidth="sm">
        <Paper elevation={3} sx={{ p: 4 }}>
          <Stack spacing={2} direction="column" alignItems="center">
            <Typography variant="h5" gutterBottom>
              Add a Book by ISBN
            </Typography>

            <TextField
              id="isbn-input"
              label="ISBN"
              variant="outlined"
              fullWidth
              value={isbn}
              onChange={(e) => setIsbn(e.target.value)}
            />

            <Stack direction="row" spacing={2} mt={2}>
              <Button
                variant="contained"
                color="primary"
                startIcon={<AddIcon />}
                onClick={handleAddBook}
              >
                Add New Book
              </Button>
              <Button
                variant="outlined"
                color="secondary"
                startIcon={<ListIcon />}
                onClick={handleAddToReadingList}
              >
                Add to Reading List
              </Button>
            </Stack>
 <Link href="/MainPage">

            <Button
              variant="text"
              color="info"
              startIcon={<VisibilityIcon />}
              sx={{ mt: 3 }}
            >
              View Added Books
            </Button>
             </Link>

 <Link href="/RaedinPage">
            <Button
              variant="text"
              color="info"
              startIcon={<VisibilityIcon />}
              sx={{ mt: 3 }}
            >
              View Reading List
            </Button>
            </Link>
          </Stack>
        </Paper>
      </Container>
    </Box>
  );
}
