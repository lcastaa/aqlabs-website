// Define a function to send the form data
function sendFormData(formData) {

    return fetch('/api/v1/form/contact', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
    })
    .then(response => response.json());
}

// Define a function to handle the form submission
function handleFormSubmission(event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const message = document.getElementById('message').value;

    const formData = {
        name,
        email,
        message,
    };

    sendFormData(formData)
        .then(data => {
            if (data.status === 'success') {
                alert('Message sent successfully');
            } else {
                alert('Failed to send message');
            }
        });
}

// Attach the event listener to the button
document.getElementById("contact-form-button").addEventListener('click', handleFormSubmission);

// Attach the event listener to the button
document.getElementById("contact-form-button").addEventListener('click', handleFormSubmission);
