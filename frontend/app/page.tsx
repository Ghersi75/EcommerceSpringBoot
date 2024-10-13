"use client";

import ItemCard from "@/components/ItemCard";
import Image from "next/image";
import { useState, useEffect } from "react";

export default function Home() {
  const [data, setData] = useState(null)

  useEffect(() => { 
    async function FetchItems() {
      let res = await fetch("localhost:8080/items")
      let data = await res.json()
      setData(data)
    }

    FetchItems()
  }, [])

  console.log(data)

  return (
    <div className="p-4 w-svw h-svh flex items-center justify-center">
      <ItemCard />
    </div>
  );
}
