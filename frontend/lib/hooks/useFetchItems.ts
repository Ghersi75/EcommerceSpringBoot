import { useState, useEffect } from "react"
import { ItemData } from "../types/StoreItemTypes"
import { compareDisplayOrder } from "../utils"

const allItemsEndpoint = "http://localhost:8080/items"

export default function useFetchItems()  {
  const [data, setData] = useState<ItemData[]>([])
  const [isLoading, setIsLoading] = useState(true)
  const [error, setError] = useState<string | null>(null)
  
  useEffect(() => { 
    async function FetchItems() {
      try {
        let res = await fetch(allItemsEndpoint)
        let resultData = await res.json()
        // Not sure why this doesnt throw an error since ItemData doesnt have displayOrder yet, but whatever
        // TODO: Fix this
        resultData.sort(compareDisplayOrder)
        setData(resultData)

      } catch (error) {
        if (error instanceof Error) {
          setError(error.message)
        }
      } finally {
        setIsLoading(false)
      }
    }

    FetchItems()
  }, [])

  return { data, isLoading, error }
}