// Define a function to send the form data
async function sendFormData() {

    try {
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const message = document.getElementById('message').value;

        const formData = {
            name,
            email,
            message,
        };

        const response = await fetch('/api/v1/form/contact', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData),
        });

        if (response.ok) {
            alert("Message Sent");
        } else {
            alert("Message Not Send");
            throw new Error("Sending form data failed.");
        }
    } catch (error) {
        console.error("Sending form data failed:", error.message);
    }
}

document.getElementById("contact-form-button").addEventListener('click', sendFormData);
