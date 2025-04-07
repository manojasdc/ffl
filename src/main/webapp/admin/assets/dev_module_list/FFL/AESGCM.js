
function base64ToUint8Array(base64) {

	const binaryString = atob(base64);
	const bytes = new Uint8Array(binaryString.length);
	for (let i = 0; i < binaryString.length; i++) {
		bytes[i] = binaryString.charCodeAt(i);
	}
	return bytes;
}



async function deriveKey(password, salt) {
	try {
		const encodedPassword = new TextEncoder().encode(password);
		const baseKey = await window.crypto.subtle.importKey(
			"raw",
			encodedPassword,
			{ name: "PBKDF2" },
			false,
			["deriveKey"]
		);

		return await window.crypto.subtle.deriveKey(
			{
				name: "PBKDF2",
				salt: salt,
				iterations: 600000,
				hash: "SHA-256",
			},
			baseKey,
			{ name: "AES-GCM", length: 256 },
			true,
			["decrypt"]
		);
	} catch (error) {
		console.error("Error deriving key:", error);
		throw error;
	}
}
async function decryptServerDatakak( encryptedData,key) {
  const { ciphertext, iv, authTag } = encryptedData;

  const dataWithAuthTag = new Uint8Array(ciphertext.length + authTag.length);
  dataWithAuthTag.set(ciphertext, 0);
  dataWithAuthTag.set(authTag, ciphertext.length);

  const decryptedContent = await window.crypto.subtle.decrypt(
    {
      name: "AES-GCM",
      iv: iv,
      tagLength: 128,
    },
    key,
    dataWithAuthTag
  );
  
  return new TextDecoder().decode(decryptedContent);
}

async function decryptData(password, encryptedData) {
	const { ciphertext, iv, authTag, salt } = encryptedData;

	const key = await deriveKey(password, salt);

	// Recombine ciphertext and authentication tag
	const dataWithAuthTag = new Uint8Array(ciphertext.length + authTag.length);
	dataWithAuthTag.set(ciphertext, 0);
	dataWithAuthTag.set(authTag, ciphertext.length);

	// Decrypt using AES-GCM
	const decryptedContent = await window.crypto.subtle.decrypt(
		{
			name: "AES-GCM",
			iv: iv,
			tagLength: 128,
		},
		key,
		dataWithAuthTag
	);

	return new TextDecoder().decode(decryptedContent);
}

async function GenerateKey() {
	const key = generateRandomString(12);
	const salt = crypto.getRandomValues(new Uint8Array(16));

	const iv = crypto.getRandomValues(new Uint8Array(12));

	const salttext = Array.from(salt)
	const saltresult = btoa(String.fromCharCode(...salttext));
	const ivtext = Array.from(iv)
	const ivresult = btoa(String.fromCharCode(...ivtext));
	document
		.getElementById("salt").value = saltresult
	document
		.getElementById("iv").value = ivresult
	document
		.getElementById("key").value = btoa(key);
		
}

async function encryptData(data) {

	const passwordKey = atob(document
		.getElementById("key").value);

	const retrievedSaltString = atob(document
		.getElementById("salt").value);


	const salt = new Uint8Array(retrievedSaltString.length);
	for (let i = 0; i < retrievedSaltString.length; i++) {
		salt[i] = retrievedSaltString.charCodeAt(i);
	}

	const retrievedIvString = atob(document
		.getElementById("iv").value);

	const iv = new Uint8Array(retrievedIvString.length);
	for (let i = 0; i < retrievedIvString.length; i++) {
		iv[i] = retrievedIvString.charCodeAt(i);
	}

	const encoder = new TextEncoder();
	const encodedData = encoder.encode(data);

	const baseKey = await crypto.subtle.importKey(
		"raw",
		encoder.encode(passwordKey), {
		name: "PBKDF2"
	},
		false,
		["deriveKey"]
	);

	const derivedKey = await crypto.subtle.deriveKey({
		name: "PBKDF2",
		salt,
		iterations: 600000,
		hash: "SHA-256",
	},
		baseKey, {
		name: "AES-GCM",
		length: 256
	},
		true,
		["encrypt", "decrypt"]
	);

	const encrypted = await crypto.subtle.encrypt({
		name: "AES-GCM",
		iv,
	},
		derivedKey,
		encodedData
	);

	const encryptedArray = new Uint8Array(encrypted);

	const ciphertext = Array.from(encryptedArray)
	const result = btoa(String.fromCharCode(...ciphertext));
	return result;
}
function generateRandomString(length) {
	const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
	let result = '';
	const charactersLength = characters.length;

	for (let i = 0; i < length; i++) {
		result += characters.charAt(Math.floor(Math.random() * charactersLength));
	}

	return result;
}
